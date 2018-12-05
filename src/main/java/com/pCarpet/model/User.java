package com.pCarpet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern.Flag;

import lombok.Getter;
import lombok.Setter;

//@Data

@Getter
@Setter
//@AllArgsConstructor
//@RequiredArgsConstructor
//@NoArgsConstructor

@Entity
public class User {
	
	public User() {
		
	}
	
//	@Autowired
//    public User(int idutente, String username,String ragioneSociale,String partitaiva,int flag) {
//        this();
//		this.iduser=idutente;
//        this.username=username;
//        this.ragioneSociale=ragioneSociale;
//        this.partitaiva=partitaiva;
//        this.flag=flag;
//    }
	

    public User(long idutente, String username,String ragioneSociale,String partitaiva) {
        this();
		this.iduser=idutente;
        this.username=username;
        this.ragioneSociale=ragioneSociale;
        this.partitaiva=partitaiva;
        this.stato=new Stato();
        this.stato.setFlag(1l);
        this.stato.setValore("attivo");
    }
	
	public User(long idutente, String username, String password,String ragioneSociale,String telefono,String mail,String partitaiva,String ruolo,Abbonamento abbonamento) {
		this();
		this.iduser=idutente;
		this.username=username;
		this.password=password;
		this.ragioneSociale=ragioneSociale;
		this.telefono=telefono;
		this.mail=mail;
		this.partitaiva=partitaiva;
		this.ruolo=ruolo;
		this.abbonamento=abbonamento;
		this.stato=new Stato();
		this.stato.setFlag(1l);
        this.stato.setValore("attivo");
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iduser;
	
	@Column
	@NotNull
    private String username;
	
	@Column
	@NotNull
    private String password;
	
	@Column(name="ragionesociale")
	@NotNull
    private String ragioneSociale;
	
	@Column
	@NotNull
    private String telefono;
	
	@Column
	@NotNull
    private String mail;
	
	@Column
	@NotNull
    private String partitaiva;
	
	@Column
	@NotNull
    private String ruolo;
	
	@ManyToOne
	@JoinColumn(name="nomeabb")
    private Abbonamento abbonamento;
	
	
	@ManyToOne
	@JoinColumn(name="flag")
	@NotNull
    private Stato stato;
	
//	@OneToMany(mappedBy = "user")
//	private List<Assegnazione> assegnazione;
	
//	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
//	@JoinTable(name="badge_aziendali",joinColumns=@JoinColumn(name="User_iduser"),
//	inverseJoinColumns=@JoinColumn(name="Badge_idbadge"))
//	private final List<Badge> b=new LinkedList<>();


    
//    public User(int idutente, String username,String ragioneSociale,String partitaiva,int flag) {
//    	this.iduser=idutente;
//    	this.username=username;
//    	this.ragioneSociale=ragioneSociale;
//    	this.partitaiva=partitaiva;
//    	this.flag=flag;
//    }
    


//    public User(int idutente, String username, String nome, String cognome, String partitaiva) {
//    	this.iduser=idutente;
//    	this.username = username;
//    	this.nome = nome;
//        this.cognome = cognome;
//        this.partitaiva = partitaiva;
//    }
    
    
    

//    public long getIduser() {
//		return iduser;
//	}
//
//    
//    
//	public void setIduser(long idutente) {
//		this.iduser = idutente;
//	}
//
//
//
//
//
//	public String getUsername() {
//		return username;
//	}
//
//
//
//
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//
//
//
//
//	public String getPassword() {
//		return password;
//	}
//
//
//
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//
//
//
//
//	public String getRagioneSociale() {
//		return ragioneSociale;
//	}
//
//
//
//
//
//	public void setRagioneSociale(String ragioneSociale) {
//		this.ragioneSociale = ragioneSociale;
//	}
//
//
//
//	public String getTelefono() {
//		return telefono;
//	}
//
//
//
//
//
//	public void setTelefono(String telefono) {
//		this.telefono = telefono;
//	}
//
//
//
//
//
//	public String getMail() {
//		return mail;
//	}
//
//
//
//
//
//	public void setMail(String mail) {
//		this.mail = mail;
//	}
//
//
//
//
//
//	public String getPartitaiva() {
//		return partitaiva;
//	}
//
//
//
//
//
//	public void setPartitaiva(String partitaiva) {
//		this.partitaiva = partitaiva;
//	}
//
//
//
//
//
//	public String getRuolo() {
//		return ruolo;
//	}
//
//
//
//
//
//	public void setRuolo(String ruolo) {
//		this.ruolo = ruolo;
//	}
//	public String getNomeAbb() {
//		return nomeAbb;
//	}
//	public void setNomeAbb(String nomeAbb) {
//		this.nomeAbb = nomeAbb;
//	}
//	
//	public long getFlag() {
//		return flag;
//	}
//	
//	public void setFlag(int flag) {
//		this.flag = flag;
//	}
//    	
//    
//
//
//
//
//	@Override
//    public boolean equals(Object o) {
//		
//		if(this==o)return true;
//		if(!(this instanceof User)) return false;
//		
//		User u=(User)o;
//		
//		if(iduser==u.iduser) return true;
//		
//		return false;
//    }

    @Override
    public int hashCode() {
        int result;
        result = ragioneSociale != null ? ragioneSociale.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "1)ID Utente: "+iduser+"\n2)Username: " + username + "\n3)Password: "+password+"\n4)Ragione Sociale: " + ragioneSociale +"\n5)Telefono: "+telefono+
        		"\n6)Mail: "+mail+"\n7)Partita Iva: "+partitaiva+"\n8)Ruolo: "+ruolo + "\n9)NomeAbb: "+abbonamento+"\n";

    }
    public String stampa() {
    return "\nId Utente"+iduser+"\nUsername: "+username+"\nRagione Sociale: "+ragioneSociale+"\nPartita iva: "+partitaiva+"\n";
    }
}

