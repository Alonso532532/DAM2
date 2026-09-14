from PyQt6.QtWidgets import QApplication, QPushButton # Se importa solo lo que necesitas

app = QApplication([]) # Hago un objeto QApplication

window = QPushButton("Pulsa") # Hago un objeto QPushButton con el texto "Pulsa" Iker 

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
