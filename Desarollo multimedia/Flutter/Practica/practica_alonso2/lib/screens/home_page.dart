import 'package:flutter/material.dart';
import 'package:practica_alonso2/providers/datos_provider.dart';
import 'package:provider/provider.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      body: Padding(
          padding: EdgeInsetsGeometry.directional(top: 280,end: 20, start: 20),
          child: Column(
            children: [
              Text("Email", textAlign: .center,),
              Text(context.watch<DatosProvider>().getEmail, textAlign: .center, style: TextStyle(
                fontSize: 30,
                fontWeight: .bold
              ),),
              SizedBox(height: 20,),
              Text("Contraseña", textAlign: .center,),
              Text(context.watch<DatosProvider>().getContrasena, textAlign: .center, style: TextStyle(
                fontSize: 30,
                fontWeight: .bold
              ),),
              SizedBox(height: 50,),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: () {
                    Navigator.pop(context);
                  },
                  style: ElevatedButton.styleFrom(
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                    backgroundColor: const Color.fromARGB(255, 51, 51, 51),
                    foregroundColor: const Color.fromARGB(255, 236, 236, 236),
                  ),
                  child: Text("Volver"),
                ),
              ),
            ],
          ),
      ),
    );
  }
}