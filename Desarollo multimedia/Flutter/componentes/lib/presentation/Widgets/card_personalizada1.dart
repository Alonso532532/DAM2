
import 'package:flutter/material.dart';

class CardTipo1 extends StatelessWidget {
  const new({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Column(
        children: [
          ListTile(
            leading: Icon(Icons.photo_album_outlined),
            title: Text("Titulo"),
            subtitle: Text("Commodo id irure excepteur ut eu duis pariatur adipisicing non ullamco in incididunt in dolore."),
          ),
          Padding(
            // Separo los botones del borde final
            padding: const EdgeInsets.only(right: 10),
            child: Row(
              // Posicionamiento
              mainAxisAlignment: .end,
              children: [
                TextButton(onPressed: (){}, child: Text("Cancelar")),
                TextButton(onPressed: (){}, child: Text("Ok")),
              ],
            ),
          ),
        ],
      ),
    );
  }
}