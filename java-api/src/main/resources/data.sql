INSERT INTO book (id, name) VALUES ('1', 'Trading_book_1');
INSERT INTO book (id, name) VALUES ('2', 'Trading_book_2');
INSERT INTO book (id, name) VALUES ('3', 'Trading_book_3');
INSERT INTO book (id, name) VALUES ('4', 'Trading_book_4');
INSERT INTO book (id, name) VALUES ('5', 'Trading_book_6');
INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('1', 'XS1988387210', '', '"BNPParibasIssu 437% Microsoft Corp (USD)"', '2021-08-05', '4.37', 'CORP', '1000', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('1', '"BNPParibasIssu 437% Microsoft Corp (USD)"');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('1', '1', '1', 'USD', 'active', '50', '90', 'buy', '2021-05-13', '2021-08-04');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('2', 'XS1988387210', '', '"BNPParibasIssu 437% Microsoft Corp (USD)"', '2021-08-05', '4.37', 'CORP', '1000', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('2', '"BNPParibasIssu 437% Microsoft Corp (USD)"');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('1', '1', '1', 'GBP', 'active', '40', '89.56', 'sell', '2021-02-04', '2021-08-04');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('3', 'USN0280EAR64', '123456780', 'Airbus 3.15%  USD', '2021-07-30', '3.15', 'CORP', '900', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('3', 'Airbus 3.15%  USD');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('2', '1', '1', 'USD', 'active', '1000', '105.775', 'buy', '2021-05-13', '2021-08-23');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('4', 'USN0280EAR64', '123456780', 'Airbus 3.15%  USD', '2021-07-30', '3.15', 'CORP', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('4', 'Airbus 3.15%  USD');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('2', '1', '1', 'GBP', 'active', '900', '105.775', 'sell', '2021-02-04', '2021-09-10');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('5', 'A12356111', '123456bh0', 'UBS Facebook (USD)', '2021-09-30', '2', 'CORP', '900', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('5', 'UBS Facebook (USD)');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('3', '1', '1', 'USD', 'active', '50', '90', 'buy', '2021-05-13', '2021-08-23');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('6', 'USN0280EAR64', '123456780', 'Airbus 3.15%  USD', '2021-07-30', '3.15', 'CORP', '900', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('6', 'Airbus 3.15%  USD');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('2', '1', '1', 'USD', 'active', '1000', '105.775', 'buy', '2021-05-13', '2021-08-23');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('7', 'A12356111', '123456bh0', 'UBS Facebook (USD)', '2021-09-30', '2', 'CORP', '900', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('7', 'UBS Facebook (USD)');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('2', '1', '1', 'USD', 'active', '50', '90', 'sell', '2021-05-13', '2021-08-23');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('8', 'USU02320AG12', 'AMZN 3.15 08/22/27 REGS', 'Amazon', '2021-08-03', '3.15', 'CORP', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('8', 'Amazon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'GBP', 'active', '60', '98.56', 'buy', '2021-02-04', '2021-09-27');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('9', 'USU02320AG12', 'AMZN 3.15 08/22/27 REGS', 'Amazon', '2021-08-03', '3.15', 'CORP', '900', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('9', 'Amazon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '50', '98.56', 'buy', '2021-08-23', '2021-08-23');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('10', 'GB00B6460505', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('10', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '1100', '110.35', 'buy', '2021-09-27', '2021-09-27');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('11', 'GB00B6460506', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('11', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '900', '110.35', 'sell', '2021-09-28', '2021-09-28');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('12', 'GB00B6460507', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('12', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '2000', '110.35', 'buy', '2021-09-29', '2021-09-29');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('13', 'GB00B6460508', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('13', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '2000', '110.35', 'sell', '2021-09-30', '2021-09-30');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('14', 'GB00B6460509', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('14', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '1000', '110.35', 'buy', '2021-10-01', '2021-10-01');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('15', 'GB00B6460510', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('15', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '900', '110.35', 'buy', '2019-10-02', '2019-10-02');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('16', 'GB00B6460511', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('16', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '1900', '110.35', 'sell', '2019-10-03', '2019-10-03');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('17', 'GB00B6460512', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('17', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '600', '110.35', 'buy', '2018-10-04', '2018-10-04');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('18', 'GB00B6460513', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('18', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '600', '110.35', 'buy', '2019-10-05', '2019-10-05');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('19', 'GB00B6460514', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('19', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '700', '110.35', 'buy', '2021-06-06', '2021-06-06');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('20', 'GB00B6460515', 'BDCHBW8', 'HM Treasury United Kingdon', '2021-08-09', '0.75', 'GOVN', '900', 'GBP', 'active');
INSERT INTO counterparty (id, name) VALUES ('20', 'HM Treasury United Kingdon');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('5', '1', '1', 'GBP', 'active', '1300', '110.35', 'sell', '2011-10-07', '2021-10-07');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('21', 'US87973RAA86', '87973RAA8', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '2021-08-06', '2.02', 'SOVN', '690', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('21', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '60', '100.13', 'buy', '2012-02-04', '2021-09-27');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('22', 'US87973RAA86', '87973RAA8', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '2021-08-06', '2.02', 'SOVN', '690', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('22', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '50', '100.13', 'buy', '2012-08-23', '2021-08-23');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('23', 'US87973RAA86', '87973RAA8', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '2021-08-06', '2.02', 'SOVN', '690', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('23', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '75', '100.13', 'buy', '2013-02-04', '2021-09-27');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('24', 'US87973RAA86', '87973RAA8', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '2021-08-06', '2.02', 'SOVN', '690', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('24', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '50', '100.13', 'buy', '2014-08-23', '2021-08-23');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('25', 'IE00B29LNP31', '87973RAA8', 'First Norway Alpha Kl.IV', '2030-12-22', '1.123', 'SOVN', '340', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('25', 'First Norway Alpha Kl.IV');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '300', '98.76', 'buy', '2016-02-04', '2021-09-27');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('26', 'IE00B29LNP31', '87973RAA8', 'First Norway Alpha Kl.IV', '2030-12-22', '1.123', 'SOVN', '340', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('26', 'First Norway Alpha Kl.IV');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '300', '98.76', 'buy', '2012-08-23', '2021-08-23');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('27', 'IE00B29LNP31', '87973RAA8', 'First Norway Alpha Kl.IV', '2030-12-22', '1.123', 'SOVN', '340', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('27', 'First Norway Alpha Kl.IV');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '300', '98.76', 'buy', '2013-02-04', '2021-09-27');INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) VALUES ('28', 'IE00B29LNP31', '87973RAA8', 'First Norway Alpha Kl.IV', '2030-12-22', '1.123', 'SOVN', '340', 'USD', 'active');
INSERT INTO counterparty (id, name) VALUES ('28', 'First Norway Alpha Kl.IV');
INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) VALUES ('4', '1', '1', 'USD', 'active', '300', '98.76', 'sell', '2015-08-23', '2021-08-23');