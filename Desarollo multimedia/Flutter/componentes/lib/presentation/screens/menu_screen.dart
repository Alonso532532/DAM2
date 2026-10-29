import 'package:componentes/models/menu_options.dart';
import 'package:flutter/material.dart';

class MenuScreen extends StatelessWidget {
   
  const MenuScreen({super.key});
  
  @override
  Widget build(BuildContext context) {

    final menuOptions = <MenuOption>[
      MenuOption(ruta: "listview1", icono: Icons.list_alt_outlined, nombre: "Lista 1"),
      MenuOption(ruta: "listview2", icono: Icons.list_alt_outlined, nombre: "Lista 2"),
      MenuOption(ruta: "card", icono: Icons.card_giftcard, nombre: "Cartas"),
      MenuOption(ruta: "alert", icono: Icons.lock_clock_outlined, nombre: "Alertas"),
      MenuOption(ruta: "buttons", icono: Icons.lock_clock_outlined, nombre: "Botones"),
    ];

    return Scaffold(
      appBar: AppBar(
        title: Text("Componentes en Flutter"),
      ),
      body: ListView.separated(
        itemBuilder: (context, i) => ListTile(
          leading: Icon(menuOptions[i].icono),
          title: Text(menuOptions[i].nombre),
          trailing: Icon(Icons.arrow_forward_ios),
          onTap: () {
            // Forma to guapa con las rutas del main
            Navigator.pushNamed(context, menuOptions[i].ruta);

            // Navegación forma no mola
            /*final route = MaterialPageRoute(builder: (context) => ListView2Screen(),);
            Navigator.push(context, route);*/
          },
        ), 
        separatorBuilder: (_, __) => Divider(), 
        itemCount: menuOptions.length)
    );
  }
}