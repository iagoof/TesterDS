
public class ArvoreVP {
	NoVP raiz;

    public ArvoreVP(int k){
        raiz = new NoVP(k);
    }

    public void left_rotate(NoVP x){
    	NoVP y = x.noDireita;
        x.noDireita = y.noEsquerda;
        if(y.noEsquerda != null) y.noEsquerda.noPai = x;
        y.noPai = x.noPai;
        if(x.noPai == null) raiz = y;
        else if(x == x.noPai.noEsquerda) x.noPai.noEsquerda = y;
        else x.noPai.noDireita = y;
        y.noEsquerda = x;
        x.noPai = y;
    }

    public void right_rotate(NoVP x){ //Igual left_rotate, só mudar direito por esquerdo
    	NoVP y = x.noEsquerda;
        x.noEsquerda = y.noDireita;
        if(y.noDireita != null) y.noDireita.noPai = x;
        y.noPai = x.noPai;
        if(x.noPai == null) raiz = y;
        else if(x == x.noPai.noDireita) x.noPai.noDireita = y;
        else x.noPai.noEsquerda = y;
        y.noDireita = x;
        x.noPai = y;
    }

    public  void add(int k){
    	NoVP aux = raiz.busca(k);
       if(k > aux.valor) this.addFix(aux.noDireita = new NoVP(k, aux));
       else if(k < aux.valor) this.addFix(aux.noEsquerda = new NoVP(k, aux));
    }

    public void addFix(NoVP z){
    	NoVP y;
        while(z.noPai != null && z.noPai.cor){ //Enquanto a cor for do nodo for vermelha
            if(z.noPai == z.noPai.noPai.noEsquerda){
                y = z.noPai.noPai.noDireita;
                if(y.cor){ //Se cor de y é vermelha
                    z.noPai.cor = false;
                    y.cor = false;
                    z.noPai.noPai.cor = true;
                    z = z.noPai.noPai;
                }else{
                    if(z == z.noPai.noDireita){
                        z = z.noPai;
                        left_rotate(z);
                    }
                    z.noPai.cor = false;
                    z.noPai.noPai.cor = true;
                    right_rotate(z.noPai.noPai);
                }
            }else{ //Mesma coisa, só onde inverte direito e esquerdo
                y = z.noPai.noPai.noEsquerda;
                if(y.cor){ //Se cor de y é vermelha
                    z.noPai.cor = false;
                    y.cor = false;
                    z.noPai.noPai.cor = true;
                    z = z.noPai.noPai;
                }else{
                    if(z == z.noPai.noEsquerda){
                        z = z.noPai;
                        right_rotate(z);
                    }
                    z.noPai.cor = false;
                    z.noPai.noPai.cor = true;
                    left_rotate(z.noPai.noPai);
                }
            }
        }
        raiz.cor = false;
    }

    public void transplant(NoVP u, NoVP v){
        if(u.noPai == null) raiz = v;
        else if(u == u.noPai.noEsquerda) u.noPai.noEsquerda = v;
        else u.noPai.noDireita = v;
        if(v != null) v.noPai = u.noPai;
    }

    public void delete(NoVP z){
    	NoVP y = z, x;
        boolean yCorOriginal = y.cor;
        if(z.noEsquerda == null){
            x = z.noDireita;
            transplant(z, z.noDireita);
        }else if(z.noDireita == null){
            x = z.noEsquerda;
            transplant(z, z.noEsquerda);
        }else{
            y = z.noDireita.minimo();
            yCorOriginal = y.cor;
            x = y.noDireita;
            if(y.noPai == z) x.noPai = y;
            else{
                transplant(y, y.noDireita);
                y.noDireita = z.noDireita;
                y.noDireita.noPai = y;
            }
            transplant(z, y);
            y.noEsquerda = z.noEsquerda;
            y.noEsquerda.noPai = y;
            y.cor = z.cor;
        }
        if(yCorOriginal == false){
            delFix(x);
        }
    }

    public void delFix(NoVP x){
    	NoVP w;
        while(x != null && x != raiz && x.cor == false){
            if(x == x.noPai.noEsquerda){
                w = x.noPai.noDireita;
                if(w.cor){ //W é vermelho ?
                    w.cor = false;
                    x.noPai.cor = true;
                    left_rotate(x.noPai);
                    w = x.noPai.noDireita;
                }
                if(w.noEsquerda.cor == false && w.noDireita.cor == false){
                    w.cor = true;
                    x = x.noPai;
                }else{
                    if(w.noDireita.cor == false){
                        w.noEsquerda.cor = false;
                        w.cor = true;
                        right_rotate(w);
                        w = x.noPai.noDireita;
                    }
                    w.cor = x.noPai.cor;
                    x.noPai.cor = false;
                    w.noDireita.cor = false;
                    left_rotate(x.noPai);
                    x = raiz;
                }
            }else{
                w = x.noPai.noEsquerda;
                if(w.cor){ //W é vermelho ?
                    w.cor = false;
                    x.noPai.cor = true;
                    right_rotate(x.noPai);
                    w = x.noPai.noEsquerda;
                }
                if(w.noDireita.cor == false && w.noEsquerda.cor == false){
                    w.cor = true;
                    x = x.noPai;
                }else{
                    if(w.noEsquerda.cor == false){
                        w.noDireita.cor = false;
                        w.cor = true;
                        left_rotate(w);
                        w = x.noPai.noEsquerda;
                    }
                    w.cor = x.noPai.cor;
                    x.noPai.cor = false;
                    w.noEsquerda.cor = false;
                    right_rotate(x.noPai);
                    x = raiz;
                }
            }
        }
        if(x != null) x.cor = false;
    }

    public NoVP encontra(int k){
    	NoVP aux = raiz.busca(k);
        if(aux.valor != k) return null;
        else return aux;
    }

}

