package hilosDelJuego;

import java.util.ArrayList;

import logicaJuego.Bomba;
import logicaJuego.Bomberman;
import logicaJuego.Mapa;

public class Bombita extends Thread {

	private Bomberman bomber;
    private Mapa map;
    private Bomba bomba;
    

    public Bombita(Bomberman bomber, Mapa test) {
        this.bomber = bomber;
        this.map = test;
      
    }
    public void run() {
    	Bomba encontrada=null;
    	ArrayList <Bomba> bombasEncontradas= new ArrayList<>();
    	
    	if(bomber.isVivo()) {
        	if(bomber.getCantBombas()!=0) {
            	bomber.setCantBombas(-1);
                bomba = bomber.ponerBomba(map);
                if (bomba != null) {
                    // Retrasamos la ejecuci�n el tiempo especificado
                    try {
                        sleep(1000 * bomba.getTiempoDeEjecucion());
                    } catch (InterruptedException e) {
                        ;
                    }
                    if(bomba.isExplotada()==false) 
                    	encontrada=bomba.explotar(map);
                   while(encontrada!=null) {
                	   	bombasEncontradas.add(encontrada);
                    	encontrada=encontrada.explotar(map);
                   }
                  
                    bomber.setCantBombas(bomber.getCantBombas()+1);
                    try {
                    	Thread.sleep(1300);
                    } catch (InterruptedException e) {
                        ;
                    }
                  
                    bomba.sacarFuego(map);
                    for(int i=0; i<bombasEncontradas.size();i++) 
                    	bombasEncontradas.get(i).sacarFuego(map);
                    
                    	              
                    try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                    
                    for(int i=0; i<map.getJugadores().size();i++) {
                    	if(!map.getJugadores().get(i).isVivo()) {
                    		map.getJugadores().get(i).revivir(map);
                    	}
                    }
                 
        		
        			}

        		}
    	}
	}
    
}