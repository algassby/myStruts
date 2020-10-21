package com.barry.myStruts.stockage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.barry.myStruts.service.Person;

public class DaoJDBCImplUSER implements Dao<Person>{


	private Logger logger;
	
	public DaoJDBCImplUSER() {
		logger = Logger.getLogger(this.getClass().getName());
	}

	@Override
	public List<Person> lireTous() {
		List<Person> ret = null;
		ResultSet rs = null;
		
		String req = "SELECT * FROM person order by id";
		try (Statement st = DaoORBUSER.getInstance().getConnection().createStatement()){
			ret = new Vector<>();
			rs = st.executeQuery(req);
			while(rs.next()) {
				ret.add(creerPOJO(rs));
			}
		} catch (SQLException e) {
			logger.log(Level.INFO,e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				logger.log(Level.INFO,e.getMessage());
			}
		}
		return ret;
	}

	private Person creerPOJO(ResultSet rs) {
		Person tmp  = null;
		tmp = new Person();
		try {
			tmp.setId(rs.getInt("id"));
			tmp.setFonction(rs.getString("fonction"));
			tmp.setNom(rs.getString("nom"));
			tmp.setPoste(rs.getString("poste"));
			tmp.setTel(rs.getInt("tel"));
			tmp.setAge(rs.getInt("age"));
			tmp.setSexe(rs.getString("sexe"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
	}

	public void ecrireTous(List<Person> elt) {
		// TODO Auto-generated method stub
		
	}

	public void modifier(int cle, Person obj) {
		PreparedStatement pst = null;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE person set nom = ?,fonction=?,poste=?,tel=?, sexe = ?, age = ? WHERE id = ? ;");
//		sql.append("UPADTE person set nom =").append(obj.getNom()).append(", fonction=").append(obj.getFonction()).append(", poste =").append(obj.getPoste()).append(",tel ="
//				).append(obj.getTel()).append("WHERE id = ").append(obj.getId()).append(";");
		try {
			DaoORBUSER.getInstance().getConnection().setAutoCommit(false);
			pst = DaoORBUSER.getInstance().getConnection().prepareStatement(sql.toString());
			pst.setString(1, obj.getNom());
			pst.setString(2, obj.getFonction());
			pst.setString(3, obj.getPoste());
			pst.setInt(4, obj.getTel());
			pst.setString(5, obj.getSexe());
			pst.setInt(6, obj.getAge());
			pst.setInt(7, cle);
			
			
			int nb = pst.executeUpdate();
			pst.close();
			// si la modification echoue, on retourne 
		    if (nb != 0) {
		    	DaoORBUSER.getInstance().getConnection().commit();
			}else {
				//si update echoue (mauvaise clef par exemple)
				DaoORBUSER.getInstance().getConnection().rollback();
			}
			
		} catch (SQLException e) {
			try {
				DaoORBUSER.getInstance().getConnection().rollback();
			} catch (SQLException e1) {
				logger.log(Level.INFO, e.getMessage());
			}
			logger.log(Level.INFO, e.getMessage());
		}finally {
			try {
				if(pst != null) {
						pst.close();
				}
				
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage());
			}
		}
		
	}

	/**
	 * obj
	 */
	public void modifier(Person obj) {
		
		
		
	}

	public void effacer(Person obj) {
		// TODO Auto-generated method stub
		
	}

	public void effacer(int cle) {
		String sql = null;
		Statement st =null;
		sql = String.join(" ", "DELETE FROM person WHERE id =",Integer.toString(cle),";");
		System.out.println(sql);
		
	try {
		DaoORBUSER.getInstance().getConnection().setAutoCommit(false);
		st = DaoORBUSER.getInstance().getConnection().createStatement();
		st.executeUpdate(sql);
		DaoORBUSER.getInstance().getConnection().commit();
	} catch (SQLException e) {
		e.printStackTrace();
		try {
			DaoORBUSER.getInstance().getConnection().rollback();
		} catch (SQLException e2) {
			logger.log(Level.INFO, e2.getMessage());
		}
	}
	finally {
		if (st!=null) {
			try {
				st.close();
			} catch (SQLException e2) {
				logger.log(Level.INFO, e2.getMessage());
			}
		}
	}
		
	}

	public void ajouter(Person obj) {
		String sql = null;
		Statement st =null;
		sql = String.join("", "INSERT INTO person VALUES (", Integer.toString(obj.getId()),",'",obj.getNom(),"','",obj.getFonction(),"','",obj.getPoste(),"',",Integer.toString(obj.getTel()),",'", obj.getSexe(),"',",Integer.toString(obj.getAge()),");");
		//sql.append("'INSERT INTO VALUES('''").append(obj.getNom()).append(",").append(obj.getFonction()).append(",").append(obj.getPoste()).append(",")
	//.append(obj.getTel()).append(");");
		
		System.out.println(sql);
		
	try {
		DaoORBUSER.getInstance().getConnection().setAutoCommit(false);
		st = DaoORBUSER.getInstance().getConnection().createStatement();
		st.executeUpdate(sql);
		DaoORBUSER.getInstance().getConnection().commit();
	} catch (SQLException e) {
		e.printStackTrace();
		try {
			DaoORBUSER.getInstance().getConnection().rollback();
		} catch (SQLException e2) {
			logger.log(Level.INFO, e2.getMessage());
		}
	}
	finally {
		if (st!=null) {
			try {
				st.close();
			} catch (SQLException e2) {
				logger.log(Level.INFO, e2.getMessage());
			}
		}
	}
		
	}

	public int getNombreEnregistrement() {
		// TODO Auto-generated method stub
		return 0;
	}


	public Person getPersonne(int cle) {
		
		ResultSet rs = null;
		Person tmp = null;
		StringBuilder req = new StringBuilder();
		req.append("SELECT * FROM person where id = ").append(cle).append(";");
		try (Statement st = DaoORBUSER.getInstance().getConnection().createStatement()){
			tmp = new Person();
			rs = st.executeQuery(req.toString());
			while(rs.next()) {
				tmp.setId(rs.getInt("id"));
				tmp.setFonction(rs.getString("fonction"));
				tmp.setNom(rs.getString("nom"));
				tmp.setPoste(rs.getString("poste"));
				tmp.setTel(rs.getInt("tel"));
				tmp.setAge(rs.getInt("age"));
				tmp.setSexe(rs.getString("sexe"));
			}
		} catch (SQLException e) {
			logger.log(Level.INFO,e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				logger.log(Level.INFO,e.getMessage());
			}
		}
		return tmp;
	}
	
	public static void main(String [] args) {
		DaoJDBCImplUSER acces = null;
		acces =  new DaoJDBCImplUSER();
		//acces.lireTous().forEach(items->System.out.println(items));
		Person tmp = new Person();
		tmp.setId(26);
		tmp.setNom("Elisabeth");
		tmp.setFonction("Enseignant");
		tmp.setPoste("Geologue");
		tmp.setTel(0256);
		tmp.setAge(49);
		tmp.setSexe("femme");
		
		//acces.ajouter(tmp);
		//acces.modifier(26, tmp);
		//acces.effacer(0);
		System.out.println("-----<Liste des personnes>-----");
		acces.lireTous().forEach(items->System.out.println(items));
		System.out.println("<------get Person------>");
	System.out.println(acces.getPersonne(5));
	
		
	}
}
