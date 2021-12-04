package br.unitins.topicos.a2.models;

public enum ClassificacaoIndicativa {
	LIVRE(1,"Livre"),
	MAIOR10(2,"+10"),
	MAIOR12(3,"+12"),
	MAIOR14(4,"+14"),
	MAIOR16(5,"+16"),
	MAIOR18(6,"+18");

	private int id;
	private String label;
	
	ClassificacaoIndicativa(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static ClassificacaoIndicativa valueOf(int id) {
		for (ClassificacaoIndicativa classificacaoIndicativa : ClassificacaoIndicativa.values()) {
			if (classificacaoIndicativa.getId() == id)
				return classificacaoIndicativa;
		}
		return null;
	}
}
