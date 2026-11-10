import 'package:flutter/material.dart';

class SliderScreen extends StatefulWidget {
   
  const SliderScreen({super.key});

  @override
  State<SliderScreen> createState() => _SliderScreenState();
}

class _SliderScreenState extends State<SliderScreen> {

  double _valorSlider = 100;
  bool _activarSlider = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Sliders y checks"),
      ),
      body: Column(
         children: [
          Slider.adaptive(
              min: 30,
              max: 400,
              value: _valorSlider, 
              onChanged: 
              // en caso de que esté activado se devuelve la función
              _activarSlider ? (valor) {
                _valorSlider = valor;
                setState(() {
                  
                });
              } : null
              // Sino se devuelve null, al ser null se desactiva
            ),
            /*
            Checkbox(
              value: _activarSlider, 
              onChanged: (valor) {
                _activarSlider = valor ?? true;
                setState(() {
                  
                });
              }
            ),
            Switch(
              value: _activarSlider, 
              onChanged: (valor) {
                _activarSlider = valor;
                setState(() {
                  
                });
              }
            )*/
            CheckboxListTile(
              title: Text("Habilitar Slider"),
              value: _activarSlider, 
              secondary: Icon(Icons.abc_outlined),
              subtitle: Text("Subtitulo"),
              onChanged: (valor) {
                _activarSlider = valor??true;
                setState(() {
                  
                });
              }
            ),
            SwitchListTile(
              title: Text("Habilitar Slider"),
              value: _activarSlider, 
              secondary: Icon(Icons.access_time_sharp),
              subtitle: Text("Subtitulo"),
              onChanged: (valor) {
                _activarSlider = valor??true;
                setState(() {
                  
                });
              }
            ),
            // El expanded permite hacer que ocupe más del espacio que tiene
            Expanded(
              // Permite que sea srolleable
              child: SingleChildScrollView(
                child: Image(
                  image: NetworkImage("https://cdn.pixabay.com/photo/2020/07/06/17/51/batman-5377804_1280.png"),
                  fit: BoxFit.contain,
                  width: _valorSlider,
                ),
              ),
            )
         ],
      ),
    );
  }
}