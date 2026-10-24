import 'package:flutter/material.dart';


class ListView1Screen extends StatelessWidget {

  final games = ["Inops", "Krunker", "Evolve", "Red death redemption II"];
  ListView1Screen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("ListView Tipo 1"),),
      body: ListView(
        children: [
          // Se pueden recorrer listas con esto:
          ...games.map((juego) => ListTile(
              title: Text(juego),
              subtitle: Text("Stanstash.corp"),
              onTap: (){},
              trailing: Icon(Icons.forward) ,
              leading: Icon(Icons.gamepad),
          )
          ).toList()
          /*
          ListTile(
            title: Text("Hola mundo"),
            leading: Icon(Icons.access_time_sharp),
            onTap: (){

            },
            trailing: Icon(Icons.arrow_forward_ios_outlined),
            subtitle: Text("pascuald asddsfan dsgfdjaf naroarngf sdfs gsgdfgf df gdg dfg"),
          ),
          ListTile(
            title: Text("Hola mundo"),
            leading: Icon(Icons.access_alarm),
          )*/
        ],
      )
   );
  }
}