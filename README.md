# admob-ads-utils

Esta clase se usa para integrar/ automatizar el proceso de entrega de anuncios con Admob.
Con esta clase podra evitar la perdida de ingresos, ya que este codgo evita que se hagan solicitudes de anuncios innecesarias (por ejemplo, solicitudes de anuncio cuando un anuncio no se ha cargado o solicitar anuncios varias veces cuando ya hay varios anuncios cargado).

Con esta clase puede tener una sola instancia, cargar una sola vez el anuncio y mantenerlo preparado para cuando un evento en la app se ejecute, no se inicialice desde cero el servicio de anuncios y entregue menos anuncios.

# Documentacion

Use el metodo initAdmob(Context context) para inicializar el servicio de anuncios. Lo recomendable es usarlo mucho antes de que la pantalla de inicio de la app termine de cargarse (por ejemplo, en el splashscreen de bienvenida).

Use el metodo prepareIntersticial para preparar el intersticial antes de mostrarse. Este metodo es el que hace la solicitud del anuncio, asi que lo ideal es que se utilice en un evento previo antes de mostrar el anuncio, para darle oportunidad a que el servicio este cargado.

Use el metodo showIntersticial para finalmente mostrar el anuncio.

# Nota
Las variables de tipo final string que estan en la clase son las que contienen el codigo de anuncio de test, y el codigo de su bloque de anuncios. Puede usar ambos segun su necesidad, pero para produccion asegurese de reemplazar el string por su bloque de anuncios.
