package Adventure.src.adventure.ClassesBasicas;

public class Ferramenta {
	private String descricao;

	public Ferramenta(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public boolean usar() {
		return true;
	}
        
        public boolean guardar() {
		return true;
	}
}
