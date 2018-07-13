	class NoVP{
	    int valor;
	    NoVP noPai;
	    NoVP noEsquerda, noDireita;
	    boolean cor; //True = vermelho

	    public NoVP(int k){
	        valor = k;
	        cor = false;
	        noEsquerda = noDireita = noPai = null;
	    }

	    public NoVP(int k, NoVP p){
	        this(k);
	        noPai = p;
	        cor = true;
	    }

	    public NoVP busca(int k){
	        if(k > this.valor && this.noDireita != null) return this.noDireita.busca(k);
	        else if(k < this.valor && this.noEsquerda != null) return this.noEsquerda.busca(k);
	        else return this;
	    }

	    public void print() {
	        System.out.println(this + ": " + this.noEsquerda + " <- (" + this.valor + "  +  " + (this.cor ? "V" : "P") + ") -> " + this.noDireita);
	        if (this.noEsquerda != null) this.noEsquerda.print();
	        if (this.noDireita != null) this.noDireita.print();
	    }

	    public NoVP minimo(){
	        if(noEsquerda != null) return noEsquerda.minimo();
	        else return this;
	    }

	}