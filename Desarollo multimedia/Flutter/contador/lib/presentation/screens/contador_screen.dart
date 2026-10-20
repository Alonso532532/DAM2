import 'package:contador/presentation/widgets/boton_personalizado.dart';
import 'package:flutter/material.dart';
// Creo un widget para usarlo
// los widgets stateless son estaticos, los stateful son dinamicos, se pueden cambiar con la bombillica
class ContadorScreen extends StatefulWidget {
  const new({super.key});

  // Que una clase rengga "_" significa que es privada
  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}


class _ContadorScreenState extends State<ContadorScreen> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // ----- La bombillica carrea dart
      // ----- Añado una barra arriba
      appBar: AppBar(
        title: Text("Contador App", ),
        backgroundColor: const Color.fromARGB(255, 255, 153, 0),
        centerTitle: true,
        //leading: 
        //  IconButton(
        //    onPressed: (){
        //      contador = 0;
        //      setState(() {});
        //    }, 
        //    icon:Icon(Icons.refresh_rounded)
        //  ),
        actions: [
          IconButton(
            color: Colors.white,
            onPressed: (){
              contador = 0;
              setState(() {});
            }, 
            icon:Icon(Icons.refresh_rounded)
          ), 
          IconButton(
            color: Colors.white,
            onPressed: (){
              contador = 0;
              setState(() {});
            }, 
            icon:Icon(Icons.refresh_rounded)
          ),
        ],
      ),

      // CUERPO
      body: Center(
        child: Column(
          // ----- Le digo que la columna los posicione en el centro
          // ----- Si se tiene que usar la clase otra vez para sacar algún valor solo hace falta un "."
          mainAxisAlignment: .center,
          children: [
            // ----- Se pueden añadir propiedades al widget 
            Text(
              contador.toString(), 
              style: TextStyle(
                fontSize: 160,
                fontWeight: .w100
              ),
            ),
            Text(contador==1 ? "Click" : "Clicks", style: TextStyle(fontSize: 45),),
            //if (contador != 1) Text("Clicks", style: TextStyle(fontSize: 45),),
            //if (contador == 1) Text("Click", style: TextStyle(fontSize: 45),),
          ],
        ),
      ),
      // ----- Botónes
      floatingActionButton: Column(
      mainAxisAlignment: .end,
      children: [
        BotonPersonalizado(icono: Icons.plus_one, funcion: (){
          contador++;
          setState(() {
            
          });
        }),
        SizedBox(height: 10,),
        BotonPersonalizado(icono: Icons.exposure_minus_1,funcion: (){
          if (contador!=0)contador --;
          setState(() {
            
          });
        }),
        SizedBox(height: 10,),
        BotonPersonalizado(icono: Icons.refresh_rounded,funcion: (){
          contador = 0;
          setState(() {
            
          });
        }),
        //FloatingActionButton(
        //  child: Icon(Icons.add),
        //  onPressed: (){ 
        //    contador++;
        //    setState(() {});
        //  },
        //  shape: StadiumBorder(),
        //  backgroundColor: const Color.fromARGB(255, 255, 153, 0),
        //),
        //SizedBox(height: 10,),
        //      FloatingActionButton(
        //  child: Icon(Icons.exposure_minus_1),
        //  onPressed: (){ 
        //    if(contador!=0)contador--;
        //    setState(() {});
        //  },
        //  shape: StadiumBorder(),
        //  backgroundColor: const Color.fromARGB(255, 255, 153, 0),
        //),
        //SizedBox(height: 10,),
        //FloatingActionButton(
        //  child: Icon(Icons.refresh_rounded),
        //  onPressed: (){ 
        //    contador = 0;
        //    setState(() {});
        //  },
        //  shape: StadiumBorder(),
        //  backgroundColor: const Color.fromARGB(255, 255, 153, 0),
        //),
      ])
      // ----- Con la bombillica se pueden extraer métodos  
      //floatingActionButton: Column(
      //mainAxisAlignment: .end,
      //children: [
      //  BotonPersonalizado(icono: Icons.refresh_rounded,),
      //  SizedBox(height: 10,),        
      //  BotonPersonalizado(icono: Icons.plus_one,),        
      //  SizedBox(height: 10,),        
      //  BotonPersonalizado(icono: Icons.exposure_minus_1,),              
      //  ],
      //)
    );
  }
}

class BotonPersonalizado extends StatelessWidget {

  final IconData icono;
  final VoidCallback? funcion;

  const new({
    super.key,
    required this.icono,
    this.funcion
  });

  @override
  Widget build(BuildContext context) {
    return FloatingActionButton(
      child: Icon(icono),
      backgroundColor: const Color.fromARGB(255, 255, 153, 0),
      shape: StadiumBorder(),
      elevation: 10,
      onPressed: funcion,
    );
  }
}