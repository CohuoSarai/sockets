import java.io.*;
import java.net.*;

public class Cliente2 {
    private String ip;
    private int puerto;
    
    public Cliente2(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }
    
    public String enviarMensaje(String mensaje) {
        String respuesta = "";
        try {
            // Creamos el socket para conectarnos al servidor
            Socket socket = new Socket(ip, puerto);

            // Creamos los flujos de entrada y salida
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // Enviamos el mensaje al servidor
            pw.println(mensaje);

            // Leemos la respuesta del servidor
            respuesta = br.readLine();

            // Cerramos los flujos y el socket
            br.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor: " + e.getMessage());
        }
        return respuesta;
    }

    public static void main(String[] args) {
    	
        // Crear un objeto Cliente2 con la IP y el puerto del servidor
        Cliente2 cliente = new Cliente2("insertar ip", 1);

        // Enviar un mensaje al servidor y obtener la respuesta
        String respuesta = cliente.enviarMensaje("Hola, servidor prueba 1!");

        // Imprimir la respuesta del servidor en la consola
        System.out.println("Respuesta del servidor +2 : " + respuesta);
    }
}
