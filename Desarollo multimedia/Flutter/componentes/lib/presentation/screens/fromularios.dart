import 'package:componentes/presentation/Widgets/custom_input_field.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
   
  const FormularioScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Formularios"),
        titleTextStyle: TextStyle(color: Colors.white, fontSize: 30),
        backgroundColor: Colors.blue,
        iconTheme: IconThemeData(color: Colors.white),
      ),
      body: SingleChildScrollView(
         child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 20, vertical: 10),
          child: Form(
            child: Column(
              children: [
                CampoDeTextoPersonalizado(coutText: "Contador",hintText: "Rellena esto", labelText: "Campo", helperText: "Sólo letras", prefixIcon: Icon(Icons.abc_sharp), sufixIcon: Icon(Icons.mediation_sharp), icon: Icon(Icons.one_k_plus_outlined),),
                CampoDeTextoPersonalizado(coutText: "Contador",hintText: "Rellena esto también", labelText: "Email", helperText: "Sólo letras", icon: Icon(Icons.one_k_plus_outlined), keyboardType: .emailAddress,),
                CampoDeTextoPersonalizado(coutText: "Contador",hintText: "Y esto", labelText: "Telefono", helperText: "Tu telefono", icon: Icon(Icons.one_k_plus_outlined), keyboardType: .phone,),
                CampoDeTextoPersonalizado(coutText: "Contador",hintText: "También esto", labelText: "Contraseña", helperText: "Tu contraseña", icon: Icon(Icons.one_k_plus_outlined), keyboardType: .visiblePassword,),
                SizedBox(height: 20,),
                DropdownButtonFormField(
                  initialValue: "admin",
                  items: [
                  DropdownMenuItem(child: Text("Admin"), value: "admin",),
                  DropdownMenuItem(child: Text("Super user"), value: "sUser",),
                  DropdownMenuItem(child: Text("Developper"), value: "developper",),
                  ], 
                  onChanged: ((value) => {
                    print(value)
                  }),
                ),
                SizedBox(height: 20,),
                ElevatedButton(onPressed: (){}, child: Text("Enviar")),
              ],
            ),
          ),
        ), 
      ),
    );
  }
}

