from PyQt6.QtWidgets import QApplication, QMainWindow # Se importa solo lo que necesitas

app = QApplication([]) # Hago un objeto QApplication

window = QMainWindow() # Hago un objeto QMainWindow con el texto "Pulsa" Iker 

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
