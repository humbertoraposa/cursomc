package com.humbertogrillo.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.humbertogrillo.cursomc.services.exception.ObjetoNaoEncontradoExcecao;

@ControllerAdvice
public class ManipuladorExcecaoRepositorio {
	
	@ExceptionHandler(ObjetoNaoEncontradoExcecao.class	)
	public ResponseEntity<ErroPadrao> objetoNaoEncontradoExcecao(ObjetoNaoEncontradoExcecao e, HttpServletRequest request){
		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
