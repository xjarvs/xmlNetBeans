/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import Clases.Alumnos;
import Clases.Salon;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Jarvs
 */
public class Xml {

    //nombre del Archivo xml a generar
    private static final String SALON_DAT_FILES = "Salon.xml";
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws JAXBException, IOException{
        //Asignamos el esquema que tendra nuestro archivo xml
       JAXBContext context = JAXBContext.newInstance(Salon.class);
       //creamos el Formador(Codificador) apartir de nuestro esquema(context) 
		Marshaller marshaller = context.createMarshaller();
                //Asignamos las propiedades a nuestro formador(esta propiedad indica que nuestro archivo tendra el formato de un tipico archivo xml)
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
                //LLenamos el objeto salon a partir del metodo llenar salon
		Salon salon = llenarSalon();
		
		//Mostramos el preview(vista previa) del documento XML a generar 
		marshaller.marshal(salon, System.out);
		
                //Asgnamos el nombre de nuestro archivo
		FileOutputStream fos = new FileOutputStream(SALON_DAT_FILES);
		//guardamos el objeto serializado en un documento XML
		marshaller.marshal(salon, fos);                
		fos.close();
		
                //creamos el desFormador(decodficador) apartir del esquema(context)
		Unmarshaller unmarshaller = context.createUnmarshaller();
		//Decodificamos a partir de nuestro documento XML creado anteriormente
		Salon salonaux = (Salon) unmarshaller.unmarshal(new File(SALON_DAT_FILES));
                
                //Imprimimos y Mostramos por linea de comandos el objeto Java Salon obtenido 
                System.out.println(salonaux.getAlumnos()[0].getNombre()+"\n"+
                                   salonaux.getAlumnos()[1].getNombre()+"\n"+
                                    salonaux.getNo()+" "+salonaux.getDescripcion()+" "+salonaux.getCapacidad());
                
		System.out.println("+++++++++ Archivo cargado desde fichero XML++++++++");
                // Mostramos por linea de comandos el objeto Java Salon obtenido en formato xml
		//producto de la decodificacion
		marshaller.marshal(salonaux, System.out);
    }
    
    private static Salon llenarSalon(){
		//lista de 2 nombres
		String[] nombresAlumnos = {"Javier", "Alberto"};
                //lista de 2 edades
		int[] edadesAlumnos = {10, 12};
                //lista de 2 grados
                int[] gradosAlumnos ={4,6};
                //lista de alumnos de 2 espacios
		Alumnos[] alumnos = new Alumnos[2];
		
                // asignamos los datos a los alumnos
		for(int i=0; i<2; i++){
                        //creamos una nueva instancia de alumnos
			alumnos[i] = new Alumnos();
                        //asignamos el nombre al alumno
			alumnos[i].setNombre(nombresAlumnos[i]);
                        //asignamos la edad al alumno
			alumnos[i].setEdad(edadesAlumnos[i]);
                        //asignamos el grado al alumno
                        alumnos[i].setGrado(gradosAlumnos[i]);
		}
		
                //creamos el objeto salon
		Salon salon = new Salon();
                //asignamos valos a los atributos del objeto Salon
                salon.setNo(3);
		salon.setDescripcion("Material 4x 6 mts");
		salon.setCapacidad(12);
                //asignamos la lista de alumnos a nuestro salon
		salon.setAlumnos(alumnos);
		return salon;
	}
    
}
