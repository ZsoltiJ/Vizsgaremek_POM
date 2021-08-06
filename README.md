# Vizsgaremek_POM


Tisztelt Hölgyem/Uram!

A tesztek futtatásához Java környezet szüséges.
A JAVA 8 JRE, JDK(Java Develpoment Kit) én a16-os verziószámút használom, de a 11-es stabil és az is megfelelő. Ezen programokat kell letöltenie. A kód Java nyelven íródott JUnit5 keretrendszerben . Valamint egy fordító programot kell telepítenie,
én a IntelliJ IDEA-t tudom ajánlani, szintén ezt használom, de az Eclipse is megfelelő compiler. Ezután a publikus GitHub repositoryból leklónozott forráskódot és egyéb kapcsolódó dokumentumokat meg tudja nyitni a compiler programmal. A workflow-ban lévő yml file tartalmazza a beállításokat az automata tesztjelentéshez. Nem szabad belejavítani, ha lehet nem is kell megnyitni. A pom.xml file szintén fontos, mert ez  tartalmaz több Maven és Allure dependeciát és pluginokat, szintén nem szabad szerkeszteni.

Webdriver Managert használok ezért bármilyen operációsrendszerű gépen lehet futtani a kódot, egy böngészőben. Ez is a pom.xml fileban van beimportálva. 
 A tesztek futtatását a tesztmappa és tesztoldalak  megnyitásával, majd a kívánt teszt (pl. a @Test annotáció melletti kis zöld háromszögre kattintással lehet ) elindítani. Jelenleg a tesztek automatikusak és nem nyitják meg a weboldalakat. Ezen lehet változtatni, hogy a BaseTest-ben a beállításokban, ki lehet ezt az opciót kommentelni, ekkor megnyitott weboldallakkal futnak. Ez esetben nem készít automata teszjelenést.
Az automata teszjelentést a GitHubon a Settings menüpont és Pages fülre kattintva, majd a zöld téglalpban megjelenő URL-re kattintva érhetik el.


Tisztelettel,


Juhász Zsolt


Megjegyzések: a tesztek az src mappán belül a a test/java mappában találhatóak.
              a tesztjelentés az alábbi linken: https://zsoltij.github.io/Vizsgaremek_POM/
