import 'package:flutter/material.dart';


class ListView2Screen extends StatelessWidget {

  final games = ["Inops", "Krunker", "Evolve", "Red death redemption II"];
  ListView2Screen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("ListView Tipo 2"),),
      // ListView.separated permite añadir un elemento entre cada elemento de la lista
      body: ListView.separated(
        itemBuilder: (_, index) => ListTile(
              title: Text(games[index]),
              subtitle: Text("Stanstash.corp"),
              onTap: (){},
              trailing: Icon(Icons.forward) ,
              leading: Icon(Icons.gamepad),
          ),
        // Si hay argumentos innecesarios se rellenan con "_"
        separatorBuilder: (_, __) => Divider(),
        itemCount: games.length,
      )
   );
  }
}