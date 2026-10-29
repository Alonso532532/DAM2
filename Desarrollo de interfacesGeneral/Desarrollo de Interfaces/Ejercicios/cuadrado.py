from PyQt6.QtGui import QColor, QPalette
from PyQt6.QtWidgets import QWidget


class Cuadrado(QWidget):
    def __init__(self, color):
        super().__init__()

        self.setAutoFillBackground(True)

        paleta = self.palette()

        paleta.setColor(QPalette.ColorRole.Window, QColor(color))

        self.setPalette(paleta)

# Crear carpeta en local y abrirla desde VSC
# Añadir extensiones
# ● python
# ● PYQT Integration
# ● Qt for Python
# 
# Crear entorno virtual (desde la Terminal)
# (se añadirá contenido a nuestra carpeta)
# 
#     python -m venv App 
# 
# Si da fallo: "Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser"
# 
#     cd .\App\Scripts\
#     .\activate
#     pip install PyQt6
# 
# Instalar Qt Designer
# 
#     pip install PySide6 (instalar Qt Designer)
#     pyside6-designer (ejecutar Qt Designer)