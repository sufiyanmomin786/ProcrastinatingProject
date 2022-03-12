package Blockchain;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//import com.google.gson.GsonBuilder;

import java.sql.*;
import  Com.Connection.Dbconn;

public class Blockchain4 {
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
        public static String Previsblk="";
        public static int Blockchaindata(String data)
        {
        	try {
        	
            String PrevHash=GetPreviousHash4();
            Dbconn.PrevHash4=PrevHash;
            blockchain=GetChain4();
			// if genasis
            int size=blockchain.size();
            if(PrevHash=="0")
            {
            blockchain.add(new Block(data, "0"));}
            else
            {
            blockchain.add(new Block(data, PrevHash));
            }
            System.out.println("System Mine the Current Transaction Block ");
            blockchain.get(size).mineBlock4(difficulty);
            if(isChainValid4()){
            	System.out.println("Four BlockChain");
          
            Dbconn.blockchain4msg=0;
            }
            else 
            {
            	Dbconn.blockchain4msg=4;
                System.out.println("Blockchain is Invalid Block Chain Four ");
            }
        	} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return Dbconn.blockchain4msg;
        }
         
	public static ArrayList<Block> GetChain4() throws Exception
        {
            String previous="0";
            ArrayList<Block> wholeTransactionChain = new ArrayList<Block>();
            Connection con  = (Connection) Dbconn.conn4();
            Statement stat = (Statement) con.createStatement();
            stat.executeQuery("select * from transhashnew");
            ResultSet rs = stat.getResultSet();
            int i=0;
            while (rs.next()) {
                if(i==0)
                wholeTransactionChain.add(new Block(rs.getString(2), "0"));
                else {
                wholeTransactionChain.add(new Block(rs.getString(2), previous));}
                previous=rs.getString(3);
                i++;
            }
            return wholeTransactionChain;
        }
        
      public static ArrayList<String> GetChainConsensus4() throws Exception
        {
            ArrayList<String> wholeTransactionChain = new ArrayList<>();
           
            Connection  con = (Connection) Dbconn.conn4();
            Statement stat = (Statement) con.createStatement();
            stat.executeQuery("select * from transhashnew");
            ResultSet rs = stat.getResultSet();
             while (rs.next()) {
                 wholeTransactionChain.add(rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
            }
            return wholeTransactionChain;
        }
        // its give the state it is a genasis block or not
public static String GetPreviousHash4()
{
            String finalhash="0";    
           try
           {
           
            Connection con =  (Connection) Dbconn.conn4();
            Statement stat = (Statement) con.createStatement();
            stat.executeQuery("select * from transhashnew");
            ResultSet rs = stat.getResultSet();
            while (rs.next()) {
               finalhash= rs.getString(3);
              }
             }
catch(Exception ex)
{
}
   return finalhash;
}
	
// This is the strategy of consus algorithm, and its applicable for n nodes
        public static Boolean isChainValid4() throws Exception {
		 ArrayList<String> CompleteList =new ArrayList<>();
                 int flag=0;
                 String hashTarget = new String(new char[difficulty]).replace('\0', '0');
                 CompleteList =GetChainConsensus4();
                 for(int startpoint=0; startpoint<CompleteList.size(); startpoint++)
                 {
                 String [] parts= CompleteList.get(startpoint).toString().split(",");
                 String Chash=parts[2];
                 if(startpoint==0) Previsblk=parts[1];
                 else {
                    if(!Previsblk.equals(Chash))
                    {flag=1;
                    //break;
                        System.out.println("Chash=>"+Chash);
                    }
                  }
                     
               	if(!parts[1].substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				flag=1; break;
			}
                Previsblk=parts[1];
                 }
		if(flag==1)
                 return false;
                else
                    return true;
	}
}