import 'package:flutter/material.dart';

import '../Widgets/card_personalizada1.dart';
import '../Widgets/card_personalizada2.dart';



class CardScreen extends StatelessWidget {
   
  const CardScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Tarjetas"),
      ),
      body: ListView(
        padding: EdgeInsets.symmetric(horizontal: 20, vertical: 10),
        children: [
          CardTipo1(),
          CardTipo2(url: "https://interreg-sudoe.eu/wp-content/uploads/elementor/thumbs/3-CALL-Daniel-Remon-Enrev-rm4kjhf0p4nfl16qhets1xqnz7s0c5n8ivgxkkdwyo.jpg?x82726", texto: "Dainiel Reymond",),
          CardTipo2(url: "https://interreg-sudoe.eu/wp-content/uploads/elementor/thumbs/3-CALL-Daniel-Remon-Enrev-rm4kjhf0p4nfl16qhets1xqnz7s0c5n8ivgxkkdwyo.jpg?x82726"),
        ],
      ),
    );
  }
}

