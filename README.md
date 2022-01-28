# admob-ads-utils

Esta clase se usa para integrar/ automatizar el proceso de entrega de anuncios con Admob.
Con esta clase podra evitar la perdida de ingresos, ya que este codgo evita que se hagan solicitudes de anuncios innecesarias (por ejemplo, solicitudes de anuncio cuando un anuncio no se ha cargado o solicitar anuncios varias veces cuando ya hay varios anuncios cargado).

Con esta clase puede tener una sola instancia, cargar una sola vez el anuncio y mantenerlo preparado para cuando un evento en la app se ejecute, no se inicialice desde cero el servicio de anuncios y entregue menos anuncios.

