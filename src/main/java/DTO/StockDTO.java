package DTO;

public class StockDTO implements GeneralDTO{
	private int id;
	private String nombre;
	private String descripcion;
	private float precio_compra;
	private float precio_venta;
	private int cantidad;
	private boolean discontinuado;
	
	public StockDTO() {
		
	}
	
	public StockDTO(String nom, String des, float pr_c, float pr_v, int cant, boolean dis) {
		this.nombre = nom;
		this.descripcion = des;
		this.precio_compra = pr_c;
		this.precio_venta = pr_v;
		this.cantidad = cant;
		this.discontinuado = dis;
	}
	
	public StockDTO(int id, String nom, String des, float pr_c, float pr_v, int cant, boolean dis) {
		this.id = id;
		this.nombre = nom;
		this.descripcion = des;
		this.precio_compra = pr_c;
		this.precio_venta = pr_v;
		this.cantidad = cant;
		this.discontinuado = dis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

	public int getCant() {
		return cantidad;
	}

	public void setCant(int cant) {
		this.cantidad = cant;
	}

	public boolean isDiscontinuado() {
		return discontinuado;
	}

	public void setDiscontinuado(boolean discontinuado) {
		this.discontinuado = discontinuado;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StockDTO [id=" + id + ", "
				+ "\n nombre =" + nombre +", "
				+ "\n descripcion =" + descripcion +","
				+ "\n precio_compra =" + precio_compra +","
				+ "\n precio_venta =" + precio_venta +","
				+ "\n cantidad =" + cantidad +","
				+ "\n discontinuado =" + discontinuado +"]";
	}
	
	
}
