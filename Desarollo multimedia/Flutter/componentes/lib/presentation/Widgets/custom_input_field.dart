import 'package:flutter/material.dart';

class CampoDeTextoPersonalizado extends StatelessWidget {

  final String hintText;
  final String labelText;
  final String coutText;
  final String helperText;
  final TextInputType? keyboardType;
  final bool obscureText; // En este caso pide un bool, no un bool? asique hay que inicializarlo
  final Icon? sufixIcon;
  final Icon? prefixIcon;
  final Icon? icon;

  const new({super.key, required this.hintText, required this.labelText, required this.coutText, required this.helperText, this.keyboardType, this.obscureText = false, this.sufixIcon, this.prefixIcon, this.icon});


  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10),
      child: TextFormField(
        //autofocus: true,
        //initialValue: "64 Lovelace Juanma",
        // Para que se ponga la primera palabra en mayusculas
        keyboardType: keyboardType == null ? .text : keyboardType,
        obscureText: obscureText,
        textCapitalization: .words,
        onChanged: (value) {
          print(value);
        },
        // Comprobación del campo
        validator: (value) {
          if(value == "") return "Este campo es requerido";
          return value!.length < 3 ? "Minimo 3 caracteres" : null;
        },
        // Cuando comprobar el validator
        autovalidateMode: .onUserInteraction,
        decoration: InputDecoration(
          hintText: hintText,
          labelText: labelText,
          helperText: helperText,
          counterText: coutText,
          suffixIcon: sufixIcon == null ? Icon(Icons.accessibility_new_outlined) : sufixIcon,
          prefixIcon: prefixIcon == null ? Icon(Icons.accessibility_new_outlined) : prefixIcon,
          icon: icon == null ? Icon(Icons.accessibility_new_outlined) : icon,
          /*
          border: OutlineInputBorder(
            borderRadius: .only(
              bottomLeft: Radius.circular(10),
              topRight: Radius.circular(10),
            )
          ),
          focusedBorder: OutlineInputBorder(
            borderSide:  BorderSide(
              width: 3,
              color: Colors.blue,
            )
          )*/
        ),
      ),
    );
  }
}
