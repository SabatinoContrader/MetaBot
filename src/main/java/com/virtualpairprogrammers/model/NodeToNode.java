package com.virtualpairprogrammers.model;

import java.util.Date;

/**
 * Rappresenta un arco nodo a nodo
 */
public class NodeToNode {

	/**
	 * Nodo padre
	 */
	private Integer firstNodeId;

	/**
	 * Nodo figlio
	 */
	private Integer secondNodeId;

	/**
	 * Info sulla persistenza
	 */
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;

	/**
	 * Costruttore con parametri
	 * 
	 * @param firstNodeId
	 * @param secondNodeId
	 * @param createdAt
	 * @param updatedAt
	 * @param deletedAt
	 */
	public NodeToNode(Integer firstNodeId, Integer secondNodeId, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.firstNodeId = firstNodeId;
		this.secondNodeId = secondNodeId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Integer getFirstNodeId() {
		return firstNodeId;
	}

	public void setFirstNodeId(Integer firstNodeId) {
		this.firstNodeId = firstNodeId;
	}

	public Integer getSecondNodeId() {
		return secondNodeId;
	}

	public void setSecondNodeId(Integer secondNodeId) {
		this.secondNodeId = secondNodeId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

}
