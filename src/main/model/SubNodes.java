package main.model;

public class SubNodes {

	private int idSubNodes;
	private int isBotMessageOptionFk;
	private int sequence;
    private int idNodesFk;
    
    
	public SubNodes(int idSubNodes, int isBotMessageOptionFk, int sequence,int idNodesFk) {
		this.idSubNodes = idSubNodes;
		this.isBotMessageOptionFk = isBotMessageOptionFk;
		this.sequence = sequence;
		this.idNodesFk = idNodesFk;
	}


	public int getIdSubNodes() {
		return idSubNodes;
	}


	public void setIdSubNodes(int idSubNodes) {
		this.idSubNodes = idSubNodes;
	}


	public int getIsBotMessageOptionFk() {
		return isBotMessageOptionFk;
	}


	public void setIsBotMessageOptionFk(int isBotMessageOptionFk) {
		this.isBotMessageOptionFk = isBotMessageOptionFk;
	}


	public int getSequence() {
		return sequence;
	}


	public void setSequence(int sequence) {
		this.sequence = sequence;
	}


	public int getIdNodesFk() {
		return idNodesFk;
	}


	public void setIdNodesFk(int idNodesFk) {
		this.idNodesFk = idNodesFk;
	}


	@Override
	public String toString() {
		return "SubNodes [idSubNodes=" + idSubNodes + ", isBotMessageOptionFk=" + isBotMessageOptionFk + ", sequence="
				+ sequence + ", idNodesFk=" + idNodesFk + "]";
	}

	
}
