package com.jeysan.cpf.decision.entity;

/**
 * @author 黄静
 * 
 */
public class Flowbasicquery3ViewPK implements java.io.Serializable {

	private Long id;
	private Integer inCause;

	public Flowbasicquery3ViewPK() {

	}

	public Flowbasicquery3ViewPK(Long id, Integer inCause) {
		this.id = id;
		this.inCause = inCause;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getInCause() {
		return inCause;
	}

	public void setInCause(Integer inCause) {
		this.inCause = inCause;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		final Flowbasicquery3ViewPK other = (Flowbasicquery3ViewPK) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (inCause == null) {
			if (other.inCause != null)
				return false;
		} else if (!inCause.equals(other.inCause))
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((inCause == null) ? 0 : inCause.hashCode());
		return result;
	}
}