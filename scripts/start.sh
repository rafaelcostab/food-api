# How start the robot selecting spring profile of production

# passing by parameter 
#java -jar ../target/food-api-0.0.1-SNAPSHOT.jar --spring.profiles.active=production

# setting variable of environment
export SPRING_PROFILES_ACTIVE=production

echo Starting spring profiles: $SPRING_PROFILES_ACTIVE

# start the project normaly
java -jar ../target/food-api-0.0.1-SNAPSHOT.jar