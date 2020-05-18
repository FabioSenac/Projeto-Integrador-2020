package com.senac.pi.excepitions;

public class MensException {

		private String mensUsuarioFinal;
		private String mensDesenvolvedor;
		
		
		public MensException(String mensUsuarioFinal, String mensDesenvolvedor) {
			super();
			this.mensUsuarioFinal = mensUsuarioFinal;
			this.mensDesenvolvedor = mensDesenvolvedor;
		}
		
		public String getMensUsuarioFinal() {
			return mensUsuarioFinal;
		}
		public void setMensUsuarioFinal(String mensUsuarioFinal) {
			this.mensUsuarioFinal = mensUsuarioFinal;
		}
		public String getMensDesenvolvedor() {
			return mensDesenvolvedor;
		}
		public void setMensDesenvolvedor(String mensDesenvolvedor) {
			this.mensDesenvolvedor = mensDesenvolvedor;
		}
	}


