package br.idea.project.enums;

public enum EtapasProjeto {
	
	INICIO(10), DEV(50), AFINAL(90), FINAL(100);
	 
	private final int valor;
	 
    EtapasProjeto(int valorOpcao){
        valor = valorOpcao;
    }
    
    public int getValor(){
        return valor;
    }
}
