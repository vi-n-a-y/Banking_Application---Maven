import { useParams } from 'react-router-dom';

const Home = () => {
  const { userData } = useParams();

  // Parse the user data from URL parameter
  const parsedUserData = JSON.parse(userData);

  return (
    <div>
    username:  {userData.uname}
    
    </div>
  );
};

export default Home;
