import 'package:flutter/material.dart';

class CardTipo2 extends StatelessWidget {
  final String texto;
  final String url;

  const CardTipo2({
    super.key,
    this.texto = '',
    required this.url,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior: Clip.antiAlias, // Evita que los elementos se salgan de la card
      shape: RoundedRectangleBorder(borderRadius: BorderRadiusGeometry.circular(10)),
      child: Column(
        children: [
          FadeInImage(
            // Coge todo el espacio que pueda
            fit: BoxFit.cover,
            image: NetworkImage(url),
            placeholder: AssetImage("assets/jar-loading.gif"),
            // Tamaño
            width: double.infinity,
            height: 200,
    
            fadeInDuration: Duration(milliseconds: 1000),
          ),
          Container(
            padding: EdgeInsets.all(10),
            child: Text(texto),
          )
        ],
      ),
    );
  }
}

