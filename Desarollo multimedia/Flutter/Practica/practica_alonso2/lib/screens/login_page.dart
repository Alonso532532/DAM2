import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {

  final emailController = TextEditingController();
  final passwordController = TextEditingController();

  @override
  void dispose() {
    emailController.dispose();
    passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
          padding: EdgeInsetsGeometry.directional(top: 280,end: 20, start: 20),
          child: Column(
            children: [
              TextFormField(
                controller: emailController,
                autofocus: true,
                keyboardType: .emailAddress,
                textAlign: .center,
                validator: (value) {
                  if(value == "") return "Este campo es requerido";
                  if (!RegExp(r'^[\w.+-]+![\w-]+(\.[\w-]+)+$').hasMatch(value!)) return "No es un correo válido";
                  return null;
                },
                autovalidateMode: .onUserInteraction,
                decoration: InputDecoration(
                  hintText: "Introduce tu email",
                  prefixIcon: Icon(Icons.email),
                  border: OutlineInputBorder(
                    borderRadius: .all(Radius.circular(10),),
                    borderSide:  BorderSide(
                      width: 1,
                      color: const Color.fromARGB(255, 160, 160, 160),
                    )
                  ),
                  focusedBorder: OutlineInputBorder(
                    borderRadius: .all(Radius.circular(10),),
                    borderSide:  BorderSide(
                      width: 3,
                      color: const Color.fromARGB(255, 160, 160, 160),
                    )
                  )
                ),
              ),
              SizedBox(height: 20,),
              TextFormField(
                controller: passwordController,
                keyboardType: .visiblePassword,
                obscureText: true,
                textAlign: .center,
                // Comprobación del campo
                validator: (value) {
                  if(value == "") return "Este campo es requerido";
                  if(value!.length < 3) "Contraseña demasiado devil";
                  return null;
                },
                // Cuando comprobar el validator
                autovalidateMode: .onUserInteraction,
                decoration: InputDecoration(
                  hintText: "Introduce tu contraseña",
                  prefixIcon: Icon(Icons.password),
                  border: OutlineInputBorder(
                    borderRadius: .all(Radius.circular(10),),
                    borderSide:  BorderSide(
                      width: 1,
                      color: const Color.fromARGB(255, 160, 160, 160),
                    )
                  ),
                  focusedBorder: OutlineInputBorder(
                    borderRadius: .all(Radius.circular(10),),
                    borderSide:  BorderSide(
                      width: 3,
                      color: const Color.fromARGB(255, 160, 160, 160),
                    )
                  )
                ),
              ),
              SizedBox(height: 50,),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: () {
                    Navigator.pushNamed(
                      context, 
                      "home",
                      arguments: {
                        "email": emailController.text,
                        "password": passwordController.text,
                      },
                    );
                  },
                  style: ElevatedButton.styleFrom(
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                    backgroundColor: const Color.fromARGB(255, 51, 51, 51),
                    foregroundColor: const Color.fromARGB(255, 236, 236, 236),
                  ),
                  child: Text("Iniciar sesión"),
                ),
              ),
            ],
          ),
      ),
    );
  }
}