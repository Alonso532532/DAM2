import 'package:flutter/material.dart';
import 'package:preferencias/config/preferences/preferencias.dart';

class SettingsScreen extends StatefulWidget {
   
  const SettingsScreen({super.key});

  @override
  State<SettingsScreen> createState() => _SettingsScreenState();
}

class _SettingsScreenState extends State<SettingsScreen> {
  /*
  bool _ubicacion = true;
  bool _camara = true;
  bool _tema_oscuro = false;
  String _nombre = "";
*/

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Preferences"),),
      body: Column(
        children: [
          SwitchListTile.adaptive(
            title: Text("Permiso de ubicación"),
            value: Preferencias.ubicacion, 
            onChanged: (value) {
              Preferencias.ubicacion = value!;
              setState(() {});
            },
          ),
          SwitchListTile.adaptive(
            title: Text("Permiso de cámara"),
            value: Preferencias.camara, 
            onChanged: (value) {
              Preferencias.camara = value!;
              setState(() {});
            },
          ),
          SwitchListTile.adaptive(
            title: Text("Modo oscuro"),
            value: Preferencias.tema_oscuro, 
            onChanged: (value) {
              Preferencias.tema_oscuro = value!;
              setState(() {});
            },
          ),
          Divider(),
          Padding(
            padding: const EdgeInsets.all(12.0),
            child: TextFormField(
              initialValue: Preferencias.nombre,
              decoration: InputDecoration(
                label: Text("Nombre"),
                helperText: "Nombre"
              ),
              onChanged: (value) {
                Preferencias.nombre = value;
              },
            ),
          )
        ],
      )
    );
  }
}