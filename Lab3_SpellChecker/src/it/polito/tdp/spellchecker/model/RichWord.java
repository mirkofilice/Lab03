package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String parola;
	boolean corretta;

	public RichWord(String parola) {
		this.parola = parola;
		this.corretta=false;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	public String getParola() {
		return parola;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (corretta ? 1231 : 1237);
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
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
		RichWord other = (RichWord) obj;
		if (corretta != other.corretta)
			return false;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "parola=" + parola + ", corretta=" + corretta ;
	}
	
	

}
