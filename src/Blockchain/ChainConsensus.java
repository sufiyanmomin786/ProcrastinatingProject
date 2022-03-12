package Blockchain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Com.Connection.Dbconn;




public class ChainConsensus {

	 public static int block1, block2, block3, block4;
	 public static String T_id1, T_id2, T_id3, T_id4;
	    public static int Node2 = 0, Node3 = 0, FP = 0, Node4 = 0,Node1 = 0,num=0;
	    public static void Consensus(String data)
	    {
	    	try {
	    		
	    		block1=Blockchain1.Blockchaindata(data);
	    		block2=Blockchain2.Blockchaindata(data);
	    		block3=Blockchain3.Blockchaindata(data);
	    		block4=Blockchain4.Blockchaindata(data);
	    		System.out.println("Block Chain First=>"+block1);
	    		System.out.println("Block Chain Second=>"+block2);
	    		System.out.println("Block Chain Three=>"+block3);
	    		System.out.println("Block Chain Four=>"+block4);
	    		// check block 1 and block2
	            if (block1==block2) {
	            	Node3= 1;
	                // block 1 and block 3 
	                if (block1==(block3)) {
	                	Node4 = 1;
	                	Node3 = 0;
	                	Node1 = 0;
	                    if (block1==(block4)) {
	                        FP = 1;
	                        Node4 = 0;
	                        Node1 = 0;
	                        Node2=0;
	                        Node3=0;
	                    }// block four
	                    else
	                    {
	                    
	                    	Node1 = 0;
	                        Node2=0;
	                        Node3=0;
	                    
	                    }
	                }// block three
	                else
	                {
	                
	                if (block1==(block4)) {
	                        FP = 1;
	                        Node4 = 0;
	                        Node1 = 0;
	                        Node2 = 0;
	                    }// block four
	                
	                }
	                
	                
	            }// Block two if end
	            else {
	            	Node2 = 1;
	            	Node3 = 1;
	            	Node1=1;
	                if (block2==(block3)) {
	                	Node3 = 0;
	                	Node4 = 1;
	                	Node2 = 0;
	                    if (block2==(block4)) {
	                        FP = 1;
	                        Node4 = 0;
	                        Node2 = 0;
	                        Node3=0;
	                    }// block four

	                }// block 3
	                else
	                {
	                
	                if (block2==(block4)) {
	                        //FP = 1;
	                	Node4 = 0;
	                        //TP1 = 0;
	                    }// block four
	                else
	                {
	                if (block1==(block3)) {
	                	Node4 = 1;
	                	Node3 = 0;
	                	Node1 = 0;
	                	Node2=1;
	                    if (block1==(block4)) {
	                        FP = 1;
	                        Node4 = 0;
	                        Node1 = 0;
	                        Node3=0;
	                    }// block four
	                    else
	                    {
	                    
	                    	Node1=0;
	                    	Node2=0;
	                    	Node3=0;
	                    
	                    }
	                }// block three
	                
	                }
	                
	                }
	            }
	            Connection con1 = (Connection) Dbconn.conn1();
	            Connection con2 = (Connection) Dbconn.conn2();
	            Connection con3 = (Connection) Dbconn.conn3();
	            Connection con4 = (Connection) Dbconn.conn4();
	    		 Statement st1, st2, st3, st4;
	    		 Statement st01, st02, st03, st04;
	    		 Statement st001, st002, st003, st004;
	    		 ResultSet rs1, rs2, rs3, rs4;
	            st1 = con1.createStatement();
	            st2 = con2.createStatement();
	    		st3 = con3.createStatement();
	            st4 = con4.createStatement();
	            st01 = con1.createStatement();
	            st02 = con2.createStatement();
	    		st03 = con3.createStatement();
	            st04 = con4.createStatement();
	            st001 = con1.createStatement();
	            st002 = con2.createStatement();
	    		st003 = con3.createStatement();
	            st004 = con4.createStatement();
	            if((FP == 1 && Node2 == 0 && Node3==0 && Node4==0 && Node1 == 0)) {
	                System.out.println("All Block Valid");
	            }else if (Node1 == 1) {
	            	st001.executeUpdate("TRUNCATE transhash");
	            	 rs1 = st2.executeQuery("select * from transhash");
	                while(rs1.next())
	                {
	                String PlainData = rs1.getString("PlainData");
	                String BlocKData = rs1.getString("BlocKData");
	                String PreviousHash = rs1.getString("PreviousHash");
	                String HashBlock = rs1.getString("HashBlock");
	                String Current_Times= rs1.getString("Current_Times");
	                st01.executeUpdate("INSERT INTO transhash (PlainData, BlocKData, PreviousHash,HashBlock,Current_Times) values('"+PlainData+"','"+BlocKData+"','"+PreviousHash+"','"+HashBlock+"','"+Current_Times+"')");
	                
	                }
	           	// st1.executeUpdate("update tblblockchain set PreviousHash='"+block2+"' where TransactionID='"+T_id1+"'");
	                System.out.println("Block One Not valid");

	            }
	            else if (Node2 == 1) {
	            	st002.executeUpdate("TRUNCATE transhash");
	           	 rs2 = st3.executeQuery("select * from transhash");
	               while(rs2.next())
	               {
	               String PlainData = rs2.getString("PlainData");
	               String BlocKData = rs2.getString("BlocKData");
	               String PreviousHash = rs2.getString("PreviousHash");
	               String HashBlock = rs2.getString("HashBlock");
	               String Current_Times= rs2.getString("Current_Times");
	               st02.executeUpdate("INSERT INTO transhash (PlainData, BlocKData, PreviousHash,HashBlock,Current_Times) values('"+PlainData+"','"+BlocKData+"','"+PreviousHash+"','"+HashBlock+"','"+Current_Times+"')");
	               
	               }
	            	
	            	System.out.println("Block Two Not valid");

	            } else if (Node3 == 1) {
	            	st003.executeUpdate("TRUNCATE transhash");
	           	 rs3 = st4.executeQuery("select * from transhash");
	               while(rs3.next())
	               {
	               String PlainData = rs3.getString("PlainData");
	               String BlocKData = rs3.getString("BlocKData");
	               String PreviousHash = rs3.getString("PreviousHash");
	               String HashBlock = rs3.getString("HashBlock");
	               String Current_Times= rs3.getString("Current_Times");
	               st03.executeUpdate("INSERT INTO transhash (PlainData, BlocKData, PreviousHash,HashBlock,Current_Times) values('"+PlainData+"','"+BlocKData+"','"+PreviousHash+"','"+HashBlock+"','"+Current_Times+"')");
	               
	               }
	            	
	            	System.out.println("Block Three Not valid");
	            } else if (Node4 == 1) {
	           	 
	            	st004.executeUpdate("TRUNCATE transhash");
	           	 rs4 = st1.executeQuery("select * from transhash");
	               while(rs4.next())
	               {
	               String PlainData = rs4.getString("PlainData");
	               String BlocKData = rs4.getString("BlocKData");
	               String PreviousHash = rs4.getString("PreviousHash");
	               String HashBlock = rs4.getString("HashBlock");
	               String Current_Times= rs4.getString("Current_Times");
	               st04.executeUpdate("INSERT INTO transhash (PlainData, BlocKData, PreviousHash,HashBlock,Current_Times) values('"+PlainData+"','"+BlocKData+"','"+PreviousHash+"','"+HashBlock+"','"+Current_Times+"')");
	               
	               }
	            	System.out.println("Block Four Not valid");
	            }
	            else
	            {
	            System.out.println("All Block Not Valid");
	            }
Connection conn = (Connection) Dbconn.conn1();
	            
	            Statement stat = (Statement) conn.createStatement();
	           
	            stat.executeUpdate("insert into transhash(PlainData,BlocKData,PreviousHash,HashBlock,Current_Times) values ('" + data +"','" + Block.hash +"','" + Dbconn.PrevHash1 +"','" + Block.timeStamp +"','" + Block.nonce +"')");
	            Connection conn2 = (Connection) Dbconn.conn2();
	            Statement stat2 = (Statement) conn2.createStatement();
	            stat2.executeUpdate("insert into transhash(PlainData,BlocKData,PreviousHash,HashBlock,Current_Times) values ('" + data +"','" + Block.hash +"','" + Dbconn.PrevHash2 +"','" + Block.timeStamp +"','" + Block.nonce +"')");
	            Connection conn3 = (Connection) Dbconn.conn3();
	            Statement stat3 = (Statement) conn3.createStatement();
	            stat3.executeUpdate("insert into transhash(PlainData,BlocKData,PreviousHash,HashBlock,Current_Times) values ('" + data +"','" + Block.hash +"','" + Dbconn.PrevHash3 +"','" + Block.timeStamp +"','" + Block.nonce +"')");
	            Connection conn4 = (Connection) Dbconn.conn4();
	            Statement stat4 = (Statement) conn4.createStatement();
	            stat4.executeUpdate("insert into transhash(PlainData,BlocKData,PreviousHash,HashBlock,Current_Times) values ('" + data +"','" + Block.hash +"','" + Dbconn.PrevHash4 +"','" + Block.timeStamp +"','" + Block.nonce +"')");
	    		
	    		} catch (SQLException | ClassNotFoundException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    }
	    public static void main(String[] args) throws ClassNotFoundException, SQLException
		{
	    	
//	    	Consensus("String plaindata");
		}
}
