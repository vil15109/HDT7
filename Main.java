

import javax.swing.JOptionPane;


public class Main {

	static String tipo="";
	static Documento diccionario= new Documento();

	static void ejecutar(){
		JOptionPane.showMessageDialog(null,"Bienvenido","Bienvenida",
				JOptionPane.INFORMATION_MESSAGE);
		tipo = JOptionPane.showInputDialog("Ingrese el tipo: ");
		diccionario.crear("Direccion del documento");
	}


	public static void main (String args[]){
		ejecutar();
		System.out.println("Busqueda inOrder");
		
		
	}
}