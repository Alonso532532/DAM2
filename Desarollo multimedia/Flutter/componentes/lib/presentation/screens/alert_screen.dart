import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class AlertScreen extends StatelessWidget {
   
  const AlertScreen({super.key});
  
  // El método que ejecuta la alerta
  void mostrarAlerta(BuildContext context){
    showDialog(
      context: context,
      barrierDismissible: false,
      builder: (context)  {
        return AlertDialog(
          title: Text("Título de la Alerta"),
          content: Column(
            mainAxisSize: .min,
            children: [
              Text("Esto es el contenido de la alerta"),
              SizedBox(height: 20,),
              FlutterLogo(
                size: 100,
              )
            ],
          ),
          // define los borónes que tendrá la alerta
          actions: [
            TextButton(onPressed: ()=> Navigator.pop(context), child: Text('Cancelar', style: TextStyle(color: Colors.red),)),
            TextButton(onPressed: ()=> Navigator.pop(context), child: Text('Ok'))
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Alertas"),
        backgroundColor: Colors.red,
        elevation: 0,
      ),
      body: Center(
         child: ElevatedButton(
          style: ElevatedButton.styleFrom(
            backgroundColor: AppTheme.secondary,
            shape: StadiumBorder()
          ),
          onPressed: (){
              mostrarAlerta(context);
            }, 
          child: Padding(
            padding: EdgeInsets.symmetric(horizontal: 10, vertical: 30),
            child: Text("Mostrar alerta"),
          )),
      ),
    );
  }
}