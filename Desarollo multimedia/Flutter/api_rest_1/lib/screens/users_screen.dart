import 'dart:ffi';

import 'package:api_rest_1/models/Usuario.dart';
import 'package:api_rest_1/services/usuario_service.dart';
import 'package:flutter/material.dart';

class UserScreen extends StatefulWidget {
   
  const UserScreen({super.key});

  @override
  State<UserScreen> createState() => _UserScreenState();
}

class _UserScreenState extends State<UserScreen> {


  // Lista de posts, hay que incializarla a null mientras no tenga datos
  late Future<List<dynamic>> _listaUsuariosFuturos;

  // Para saber si está cargando los datos
  bool isLoading = false;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    _listaUsuariosFuturos = UserService().obtenerUsers();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Usuarios"),
        backgroundColor: Colors.blue,
        centerTitle: true,
        titleTextStyle: TextStyle(
          fontSize: 30,
          fontWeight: .bold,
          color: Colors.white
        ),
      ),
      body: FutureBuilder(
        future: _listaUsuariosFuturos,
       builder: (context, snapshot) {
         if (snapshot.connectionState == ConnectionState.waiting){
          return Center(child: CircularProgressIndicator.adaptive(),);
         } else if (snapshot.hasError){
          return Center(child: Text("Error: ${snapshot.error}"),);
         } else {
          final listUsuarios = snapshot.data!;
          return ListView.builder(
            itemBuilder: (context, index) {
              //Para agilizar las cosas
              final usuario = listUsuarios[index];
              return ListTile(
                title: Text(usuario["name"]),
                subtitle: Text(usuario["address"]["street"]),
              );
            },
            itemCount: listUsuarios.length,
          );
         }
       },
       )
    );
  }
}