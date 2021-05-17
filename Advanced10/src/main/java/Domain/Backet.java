package Domain;

import java.util.Date;

public class Backet {
	private int id;
	private int user_id;
	private int product_id;
	private Date  purches_date;
	public Backet(int id, int user_id, int product_id, Date purches_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.purches_date = purches_date;
	}
	public Backet(int user_id, int product_id, Date purches_date) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.purches_date = purches_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Date getPurches_date() {
		return purches_date;
	}
	public void setPurches_date(Date purches_date) {
		this.purches_date = purches_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + product_id;
		result = prime * result + ((purches_date == null) ? 0 : purches_date.hashCode());
		result = prime * result + user_id;
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
		Backet other = (Backet) obj;
		if (id != other.id)
			return false;
		if (product_id != other.product_id)
			return false;
		if (purches_date == null) {
			if (other.purches_date != null)
				return false;
		} else if (!purches_date.equals(other.purches_date))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Backet [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", purches_date="
				+ purches_date + "]";
	}
	
}
