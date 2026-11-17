import 'package:componentes/presentation/Widgets/custom_input_field.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
   
  const FormularioScreen({super.key});
  
  @override
  Widget build(BuildContext context) {

    // GlovalKey nos permite controlar y validar el formulario completo
    final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

    final Map<String, String> formValues = {
      'first_name' : '',
      'last_name' : '',
      'tfno' : '',
      'password' : '',
      'email' : '',
      'role' : 'user'
    };

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
            key: _formKey,
            child: Column(
              children: [
                CampoDeTextoPersonalizado(formValues: formValues, formProperty: 'first_name', coutText: "Contador",hintText: "Rellena esto", labelText: "Campo", helperText: "Sólo letras", prefixIcon: Icon(Icons.abc_sharp), sufixIcon: Icon(Icons.mediation_sharp), icon: Icon(Icons.one_k_plus_outlined),),
                CampoDeTextoPersonalizado(formValues: formValues, formProperty: 'email', coutText: "Contador",hintText: "Rellena esto también", labelText: "Email", helperText: "Sólo letras", icon: Icon(Icons.one_k_plus_outlined), keyboardType: .emailAddress,),
                CampoDeTextoPersonalizado(formValues: formValues, formProperty: 'tfno', coutText: "Contador",hintText: "Y esto", labelText: "Telefono", helperText: "Tu telefono", icon: Icon(Icons.one_k_plus_outlined), keyboardType: .phone,),
                CampoDeTextoPersonalizado(formValues: formValues, formProperty: 'password', coutText: "Contador",hintText: "También esto", labelText: "Contraseña", helperText: "Tu contraseña", icon: Icon(Icons.one_k_plus_outlined), keyboardType: .visiblePassword,),
                SizedBox(height: 20,),
                DropdownButtonFormField(
                  initialValue: "admin",
                  items: [
                    // El value no puede empezar por mayusculas
                  DropdownMenuItem(child: Text("Admin"), value: "admin",),
                  DropdownMenuItem(child: Text("Super user"), value: "superUser",),
                  DropdownMenuItem(child: Text("Developper"), value: "developper",),
                  ], 
                  onChanged: ((value) => formValues['role'] = value ?? 'User'),
                ),
                SizedBox(height: 20,),
                ElevatedButton(
                  onPressed: (){
                    print(formValues);
                  }, 
                  child: Text("Enviar")),
              ],
            ),
          ),
        ), 
      ),
    );
  }
}

