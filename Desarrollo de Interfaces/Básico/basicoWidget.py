from PyQt6.QtWidgets import QApplication, QWidget # Se importa solo lo que necesitas

app = QApplication([]) # Hago un objeto QApplication

window = QWidget() # Hago un objeto QWidget

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta

