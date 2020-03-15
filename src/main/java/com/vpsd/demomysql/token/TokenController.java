package com.vpsd.demomysql.token;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo/token")
public class TokenController {

	@Autowired
	ITokenRepository tokenRepository;

	@RequestMapping(method = RequestMethod.GET, path = "")
	public @ResponseBody Iterable<Token> findAllTokens() {
		System.out.println("Find all tokens");
		return tokenRepository.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public @ResponseBody Token createToken(@RequestBody Token requestToken) {
		Token token = new Token();
		token.setAccessToken(requestToken.getAccessToken());
		token.setMacAddress(requestToken.getMacAddress());
		token.setRefreshToken(requestToken.getRefreshToken());
		token.setUsername(requestToken.getUsername());
		tokenRepository.save(token);
		return token;
	}

}
