<h2>Rideforce</h2>
Rideforce, the ride-share app, is a full-stack <strong>Microservices</strong> application that allows riders access to a curated list of opted-in drivers, ranking matches based on physical proximity, comparable scheduling, and a rider's option of liking or disliking a driver. <br><br>
Application has three tiers of user roles: admin, trainer, and associate. 
<br><br>
Information accessible to all users includes 
<ul>
  <li>Preferred contact information</li>
  <li>Photograph</li> 
  <li>Description of driver vehicle</li>
  <li>User bio <i>(optional)</i></li>
  </ul>
<h3>Technologies</h3>
The individual services use 
<ul>
  <li><strong>Spring Boot</strong></li>
  <li><strong>Spring Cloud Netflix</strong></li>
</ul>
Matching Service relies on 
<ul>
  <li><strong>Feign Client</strong> to gather relevant data for the matching algorithm</li>
  <li><strong>Spring Boot Test</strong>, which includes <strong>JUnit</strong> and <strong>Data JPA Test</strong> for testing</li>
  <li><strong>SonarLint</strong> and <strong>SonarCloud</strong> for code quality assurance</li>
  <li><strong>LogBack</strong> for logging</li>
  <li><strong>JavaDocs</strong> for documentation</li>
  <li><strong>GitHub</strong> and <strong>Maven</strong> for DevOps
</ul>
  
<h5>Link to Rideforce Matching Service: https://github.com/revaturelabs/rideshare-matching-service</h5>
