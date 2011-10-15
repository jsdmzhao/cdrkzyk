package com.jeysan.cpf.decision.entity;

/**
 * @author 黄静
 * 
 */
public class Flowbasicquery2ViewPK implements java.io.Serializable {

	private Long id;
	private Integer outType;

	public Flowbasicquery2ViewPK() {

	}

	public Flowbasicquery2ViewPK(Long id, Integer outType) {
		this.id = id;
		this.outType = outType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getInCause() {
		return outType;
	}

	public void setInCause(Integer outType) {
		this.outType = outType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		final Flowbasicquery2ViewPK other = (Flowbasicquery2ViewPK) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (outType == null) {
			if (other.outType != null)
				return false;
		} else if (!outType.equals(other.outType))
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((outType == null) ? 0 : outType.hashCode());
		return result;
	}
}