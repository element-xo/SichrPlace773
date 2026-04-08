import { useParams } from 'react-router-dom';

export function MessageThreadPage() {
  const { threadId } = useParams();

  return (
    <div>
      <h1>Messaging and booking application</h1>
      <p>Coming soon</p>
      <p>Thread ID: {threadId}</p>
    </div>
  );
}

export default MessageThreadPage;
