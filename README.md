# 🚀 2단계 - 로또(자동)

## 기능 목록
* 로또 요구사항을 파악한다.
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.

    </br>

* 로또 1장의 가격은 1000원이다.
    * 입력한 금액은 1000의 배수여야한다.
    * 1000의 배수가 아니라면 예외 처리를 한다.
    * 입력받은 숫자 / 1000만큼의 랜덤 숫자 6개를 출력한다.
      * 한 배열의 숫자는 중복될수 없다.
      
    </br>

    * 출력이 끝난후 당첨 번호를 입력 받는다.
      * 당첨번호 6자리 이다.
      * 당첨번호는 중복될수 없다.
      * 중복될 6자리가 아니거나, 중복 숫자 일 경 예외 처리를 한다.

    </br>
  
    * 입력 받은 당첨 번호와 생성한 랜덤 배열들을 비교한다.
      * 3개 일치 이상부터 개수를 표기한다.
      * 총 당첨금을 계산한다.
      * 구입 금액과 비교해 수익률을 출력한다.