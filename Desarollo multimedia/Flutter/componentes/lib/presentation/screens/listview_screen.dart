import 'package:flutter/material.dart';


class ListView1Screen extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("ListView Tipo 1"),),
      body: ListView(
        children: [
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
          )
        ],
      )
   );
  }
}