package com.otn.common.beans;

/**
 * 测试Hibernate bean
 * @author 高彪
 *
 * 2014年5月25日
 */
public class TestBean implements java.io.Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	// Fields

	private int id;
	
	/**
	 * 测试字段
	 */
	private String name;

	// Constructors

	/** default constructor */
	public TestBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestBean other = (TestBean) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TestBean [id=" + id + ", name=" + name + "]";
	}
}
